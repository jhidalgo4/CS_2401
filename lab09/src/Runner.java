//Joaquin Hidalgo
//CS 2401 | lab 9

public class Runner {
	static void printQueue(Queue que) {
		if (que.isEmpty() ) {
			System.out.println("Queue was empty, Done!");
		}
		else {
			int size = que.size();
			for(int i =0; i< size; i++) {
				int temp = que.dequeue();  //Pop
                que.enqueue(temp);  //Enqueue
                System.out.println(temp);
			}
		}
	}
	
	public static void findMaxInQueue(Queue que){
		int maxNum = Integer.MIN_VALUE;
		
		if(que.isEmpty() ) {
			System.out.println("Queue was empty");
		}
		else {
			int size = que.size();
			for (int i =0; i< size; i++) {
				int temp = que.dequeue();
				if (temp > maxNum) {
					temp = maxNum;
				}
				que.enqueue(temp);
			}
			System.out.println("Max int: " + maxNum);
		}
	}
	
	static void reverseQueue(Queue que) {
		if (que.isEmpty()) return;
		
		int temp = que.dequeue();  //dequeue element from Queue
		reverseQueue(que);  //Recursive call by sending new Queue with most recent queue
		que.enqueue(temp);  //Once done with the recursive call, start fillin up Queue in reverse
	}
	
	public static void main(String[] args) {
        //MY TEST TO ADD 6 ELEMENTS TO A SIZE 5 ARRAY QUEUE. BELOW THE ARRAY SIZE IS DOUBLED
        //WHILE THE FRONT OF THE QUEUE IS IN THE MIDDLE OF THE ARRAY. WORKS WELL :) (i think lol)

        Queue qu = new Queue();  //Initiate the Queue
        
        qu.enqueue(10);
        qu.enqueue(20);
        qu.enqueue(30);
        qu.dequeue();
        qu.dequeue();
        qu.enqueue(40);
        qu.enqueue(50);
        qu.enqueue(60);
        qu.enqueue(70);
        qu.enqueue(100);
        
        printQueue(qu);  //Print queue

        reverseQueue(qu);  //Reverse queue
        System.out.println();
        printQueue(qu);  //Print queue
	}
	

}
