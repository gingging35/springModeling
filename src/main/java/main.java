class vehicle{
    private final int num;
    private String condition;
    private int passenger;

    public vehicle(int num) {
        this.num = num;
        this.condition = condition;
        this.passenger = passenger;
    }
}

class bus extends vehicle {
    private String condition;
    private int passenger;
    private int fuel;

    public bus(int num, int fuel) {
        super(num);
        this.fuel = fuel;
        this.condition = condition;
        this.passenger = passenger;
    }

    void getPassenger(int passenger) {
        this.passenger += passenger;
        if (this.passenger > 30) {
            System.out.println("최대 승객 수 초과");
        } else{
            System.out.printf("총 탑승 승객 수: %d\n",this.passenger);
            System.out.printf("잔여 승객 수: %d\n",30-this.passenger);
            System.out.printf("요금 : %d\n",this.passenger*1000);}
    }

    void getCondition(String condtion) {
        System.out.println("상태="+condtion);
        System.out.printf("주유량= %d\n", this.fuel);
    }

    void getFuel(int fuel) {
        this.fuel += fuel;
        if (this.fuel > 100) {
            System.out.println("가득찼습니다.");
        }else if(this.fuel<=5){
            System.out.println("주유 필요");
        }else
            System.out.printf("주유량= %d\n", this.fuel);
    }



}

class taxi extends vehicle {
    private String condition;
    private int passenger;
    private String destination;
    private int distance;
    private int getMoney;
    private int fuel;

    public taxi(int num, int fuel, String condtion) {
        super(num);
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
        } else{
            System.out.printf("총 탑승 승객 수: %d\n",passenger);
            System.out.printf("잔여 승객 수: %d\n",4-passenger);
            System.out.printf("기본 요금 확인 : %d\n",3000);}
            System.out.printf("목적지 : %s\n",destination);
            System.out.printf("목적지까지 거리 : %dkm\n",distance);
            System.out.printf("지불할 요금 : %d\n",price);
            System.out.printf("상태 : %s\n","운행중");
    }

    void getFuel(int fuel) {
        this.fuel+= fuel;
        if (this.fuel > 100) {
            System.out.println("가득찼습니다.");
        }else if(this.fuel<=5){
            System.out.printf("주유량= %d\n", this.fuel);
            System.out.println("상태 = 운행불가");
            System.out.printf("누적요금= %d\n", this.getMoney);
        }else {
            System.out.printf("주유량= %d\n", this.fuel);
            System.out.printf("누적요금= %d\n", this.getMoney);
        }
    }

    void getCondition(String condtion) {
        System.out.println("상태="+condtion);
        System.out.printf("주유량= %d\n", this.fuel);
    }



}

public class main {
    public static void main(String[] args) {

        bus b = new bus(1000,100);

        taxi t = new taxi(1111,100,"일반");
//        t.getPassenger(2,"서울역", 2);
//        System.out.println("");
//        t.getPassenger(3,"구디", 12);
//
//        System.out.println("");
//
//        t.getFuel(-20);
//        System.out.println("");
//
//        t.getFuel(-20);
//        System.out.println("");
//        b.getPassenger(2);
        t.getPassenger(2, "대구",12);
        t.getFuel(-10);
        t.getFuel(-70);


    }
}
