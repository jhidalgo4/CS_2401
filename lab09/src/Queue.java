public class Queue {
	
	private int[] items;  //The array of the Queue
    private int QUEUE_SIZE = 5;  //Initial size of the Queue array
    private int front, back, count;

    //Constructor
    public Queue() {
        items = new int[QUEUE_SIZE];
        front = 0;
        back = QUEUE_SIZE -1; //Sets back as the last index of the Queue array
        count =0;
    }
    
    //Checks if Queue is Empty
    public boolean isEmpty(){
        return count ==0;
    }

    //Checks if Queue is Full
    public boolean isFull(){
        return count == QUEUE_SIZE;
    }

    //Dequeue first element added from Queue
    public int dequeue(){
        if (!isEmpty()){
            int queueFront = items[front];
            front = (front+1) % QUEUE_SIZE;
            count--;  //Decrement size of elements in Queue
            return queueFront;
        }
        else{
            System.out.println("Trying to dequeue from empty queue");
            return Integer.MIN_VALUE;

        }
    }

    //ENQUEUE element to the index +1 from current back position 
    public void enqueue(int newItem){
        if ( !isFull() ){
            back = (back+1) % QUEUE_SIZE;  //Get new position to Enqueue new item
            items[back] = newItem;   //Set enqueue
            count++;   //Increment number of elements 
            return;
        }
        
        //GO in here if Queue is max filled
        else{
            int newSize = QUEUE_SIZE * 2;  //Double size of original array to make space for new array
            int[] newArray = new int[newSize];  //newArray will be our "temporary" array to fill
            
            // 'i' will be the start of our new array to enqueue, that being said, if our front element
            //  ... in our previous array was in the middle, now our front is at position 0 in array
            int i =0;
            while (i< QUEUE_SIZE ){
                
                newArray[i] = items[front];   //Fill up new array from old array. (QUEUE = FIFO)
                front = (front +1) % QUEUE_SIZE; //Increment our front by 1 each time
                i++;
            }
            
            newArray[i] = newItem;  //Insert that new element that was trying to be added to the full array when array was previously filled
            front = 0;   // Our new front is in location 0
            items = newArray;   //Update old filled array with NEW array that has been doubled in size
            back = QUEUE_SIZE;  //Back is always sitting at the last element of the array that actually has an int
            count = QUEUE_SIZE + 1;
            QUEUE_SIZE = newSize;
            System.out.println("You just doubled the array size");
            return;
        }
    }

    //Make Queue empty and reset to deafult settings
    public void dequeueAll(){
        items = new int[QUEUE_SIZE];
        front = 0;
        back = QUEUE_SIZE -1;
        count =0;
    }

    //Get the first element added to the Queue without removing it
    public int peek(){
        if (!isEmpty()) {
            return items[front];
        }
        else {
            System.out.println("Trying to peek with empty queue");
            return Integer.MIN_VALUE;
        }
    }

    //Get the current amount of elements in the Queue
    public int size(){
        return count;
    }
}