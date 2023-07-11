package executors;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Diese Klasse demonstriert die Verwendung von Executors zur Verwaltung von Threads.
 * Sie zeigt die Verwendung von Callables und Futures, Locks, atomaren Variablen und Conditions.
 */
public class ExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        int anzahlThreads = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(anzahlThreads);

        // Demonstration der Verwendung von Callables und Futures
        Callable<Integer> callableTask = () -> {
            System.out.println("Callable-Task wird ausgeführt in Thread: " + Thread.currentThread().getName());
            return ThreadLocalRandom.current().nextInt(1, 11);
        };

        Future<Integer> future = executorService.submit(callableTask);
        try {
            int ergebnis = future.get();
            System.out.println("Ergebnis des Callable-Tasks: " + ergebnis);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // Demonstration der Verwendung von Locks, atomaren Variablen und Conditions
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        AtomicInteger counter = new AtomicInteger(0);

        Runnable incrementTask = () -> {
            lock.lock();
            try {
                while (counter.get() < 10) {
                    System.out.println("Increment-Task erhöht den Zähler: " + counter.incrementAndGet());
                    condition.signalAll();
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };

        Runnable decrementTask = () -> {
            lock.lock();
            try {
                while (counter.get() > 0) {
                    System.out.println("Decrement-Task verringert den Zähler: " + counter.decrementAndGet());
                    condition.signalAll();
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        };

        executorService.execute(incrementTask);
        executorService.execute(decrementTask);

        Thread.sleep(2000); // Wartezeit, um die Ausführung zu demonstrieren

        executorService.shutdown();
    }
}

