import java.util.Scanner;

class vehicle{
    protected final int num;
    protected String condition;
    protected int passenger;
    protected int fuel;

    public vehicle(int num,int fuel) {
        this.num = num;
        this.condition = condition;
        this.passenger = passenger;
    }
}

class bus extends vehicle {
    private String condition;
    private int passenger;
    private int speed = 0;
    protected int fuel = 100;


    public bus(int num, int fuel) {
        super(num,fuel);
        this.condition = condition;
        this.passenger = passenger;
    }

    void getStatus() {
        System.out.printf("버스 번호: %d\n",super.num );
        System.out.printf("상태: %s\n",this.condition);
        System.out.printf("현재 주유량: %s\n",this.fuel);
        System.out.printf("현재 속도: %s\n",this.speed);
        System.out.printf("승객 수: %d\n\n",this.passenger);
    }

    void getSpeed(int speed) {
        if (this.condition == "운행") {
            this.speed = speed;
            System.out.println("현재속력: "+speed);
        } else {
            System.out.println("속도입력불가");
        }

    }

    void getPassenger(int passenger) {
        this.passenger += passenger;
        if (this.passenger > 30) {
            this.condition = "운행불가";
            System.out.println("운행불가");
            System.out.printf("\t최대 승객 수 초과(%d)\n\n",this.passenger);
        } else if (this.condition == "운행불가" ||this.condition =="차고지행") {
            this.condition = "운행불가";
            System.out.println("운행불가");
            System.out.printf("\t주유량 부족(%d)\n\n",this.fuel);
        } else {
            this.condition = "운행";
            System.out.printf("총 탑승 승객 수: %d\n", this.passenger);
            System.out.printf("잔여 승객 수: %d\n", 30 - this.passenger);
            System.out.printf("요금 : %d\n\n", this.passenger * 1000);
        }

    }

    void getCondition(String condtion) {
        System.out.println("상태="+condtion);
        System.out.printf("주유량= %d\n\n", this.fuel);
    }

    void getFuel(int fuel) {
        this.fuel += fuel;
        if (this.fuel > 100) {
            System.out.println("가득찼습니다.");
        }else if(this.fuel<10){
            this.condition = "차고지행";
            System.out.println("주유 필요가 필요합니다.");
            System.out.println("상태: "+this.condition);
            System.out.printf("주유량= %d\n\n", this.fuel);
        }else
            System.out.printf("주유량= %d\n\n", this.fuel);
    }



}

class taxi extends vehicle {
    private String condition;
    private int passenger;
    private String destination;
    private int distance;
    private int getMoney;

    public taxi(int num, int fuel, String condtion) {
        super(num,fuel);
        this.fuel = fuel;
        this.condition = condition;
        this.passenger = passenger;
        this.getMoney = getMoney;

    }


    void getPassenger(int passenger,String destination, int distance) {
        this.getMoney += 3000+(distance-1)*1000;
        int price = 3000 + (distance - 1) * 1000;
        if (distance > 10) {
            price = 4000+ (distance - 1) * 1000;
        }else{
            price = 3000+ (distance - 1) * 1000;
        }
        if (this.passenger > 5) {
            System.out.println("최대 승객 수 초과");
            this.condition = "운행불가";
        } else{
            System.out.printf("총 탑승 승객 수: %d\n",passenger);
            System.out.printf("잔여 승객 수: %d\n",4-passenger);
            System.out.printf("기본 요금 확인 : %d\n",3000);}
        System.out.printf("목적지 : %s\n",destination);
        System.out.printf("목적지까지 거리 : %dkm\n",distance);
        System.out.printf("지불할 요금 : %d\n",price);
        System.out.printf("상태 : %s\n\n","운행중");
    }

    void getFuel(int fuel) {
        this.fuel+= fuel;
        if (this.fuel > 100) {
            System.out.println("가득찼습니다.");
        }else if(this.fuel<=5){
            System.out.printf("주유량= %d\n", this.fuel);
            System.out.printf("누적요금= %d\n\n", this.getMoney);
        }else {
            System.out.printf("주유량= %d\n", this.fuel);
            System.out.printf("누적요금= %d\n\n", this.getMoney);
            this.condition = "운행";
        }
    }

    void getCondition(String condtion) {
        System.out.println("상태="+condtion);
        System.out.printf("주유량= %d\n\n", this.fuel);
    }



}

public class main {
    public static void main(String[] args) {

        bus b = new bus(1234,100);

//        taxi t = new taxi(1111,100,"일반");

//        t.getPassenger(2, "대구",12);
        b.getStatus();
        b.getPassenger(2);
        b.getSpeed(20);

    }
}
