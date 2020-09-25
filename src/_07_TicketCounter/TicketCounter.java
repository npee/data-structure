package _07_TicketCounter;

import structures.LinkedQueue;

public class TicketCounter {
    final static int PROCESS = 120;
    final static int MAX_CASHIERS = 10;
    final static int NUM_CUSTOMERS = 100;

    public static void main(String[] args) {
        Customer customer;
        LinkedQueue<Customer> customerQueue = new LinkedQueue<>();
        int[] cashierTime = new int[MAX_CASHIERS];
        int totalTime, averageTime, departs;

        // 다양한 수의 캐셔에 대한 시뮬레이션 처리
        for (int cashiers = 0; cashiers < MAX_CASHIERS; cashiers++) {
           // 각 캐셔의 시간을 0으로 초기화
           for (int count = 0; count < cashiers; count++) {
                cashierTime[count] = 0;
           }

           // 고객 큐 로드
           for (int count = 1; count <= NUM_CUSTOMERS; count++) {
               customerQueue.enqueue(new Customer(count * 15));
           }
           totalTime = 0;

           // 큐의 모든 고객 처리
           while (!customerQueue.isEmpty()) {
               for (int count = 0; count <= cashiers; count++) {
                   if (!customerQueue.isEmpty()) {
                       customer = customerQueue.dequeue();
                       if (customer.getArrivalTime() > cashierTime[count]) {
                           departs = customer.getArrivalTime() + PROCESS;
                       } else {
                           departs = cashierTime[count] + PROCESS;
                       }
                       customer.setDepartureTime(departs);
                       cashierTime[count] = departs;
                       totalTime += customer.totalTime();
                   }
               }
           }

           // 시뮬레이션 결과 출력
           averageTime = totalTime / NUM_CUSTOMERS;
           System.out.println("Number of cashiers " + (cashiers + 1));
           System.out.println("Average time: " + averageTime + "\n");
        }
    }
}
