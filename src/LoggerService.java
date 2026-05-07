//service class to handle logging operations

class LoggerService {
    int x; //just for example

    public LoggerService(int y){
        x = y;    
    }

    public void run(){
        System.out.println("Running logger service with x = " + x);
    }
}

