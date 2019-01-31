package butler_java2_lab3_parkingticketsimulator;

public class Butler_Java2_Lab3_ParkingTicketSimulator {

    public static void main(String[] args) {
        ParkedCar pCar1 = new ParkedCar("Toyota", "Rav4", "Blue", "RDHJ0562", 120);
        ParkingMeter pMeter1 = new ParkingMeter(60);
        PoliceOfficer pOff1 = new PoliceOfficer("John Smith", 465748, pCar1, pMeter1);
        
        ParkedCar pCar2 = new ParkedCar("Toyota", "Corola", "Red", "CLKH5689", 250);
        ParkingMeter pMeter2 = new ParkingMeter(60);
        PoliceOfficer pOff2 = new PoliceOfficer("Taylor John", 856987, pCar2, pMeter2);
        
        ParkedCar pCar3 = new ParkedCar("Honda", "Accord", "Red", "BNG5864", 250);
        ParkingMeter pMeter3 = new ParkingMeter(250);
        PoliceOfficer pOff3 = new PoliceOfficer("Robert Johnson", 695845, pCar3, pMeter3);
        
        //First Officer
        System.out.println("Officer " + pOff1.getName() + " is analyzing the parking meter for the " + pCar1.getMake() + " " + pCar1.getModel());
        if(pOff1.parkedIllegal()){
            System.out.println("The " + pCar1.getMake() + " " + pCar1.getModel() + " is parked Illegaly. Issuing parking ticket...");
            pOff1.issueTicket();
        }
        else{
            System.out.println("Car is parked legally.");
        }

        //Second Officer
        System.out.println("Officer " + pOff2.getName() + " is analyzing the parking meter for the " + pCar2.getMake() + " " + pCar2.getModel());
        if(pOff2.parkedIllegal()){
            System.out.println("The " + pCar2.getMake() + " " + pCar2.getModel() + " is parked Illegaly. Issuing parking ticket...");
            pOff2.issueTicket();
        }
        else{
            System.out.println("Car is parked legally.");
        }
        
        //Third Officer
        System.out.println("Officer " + pOff3.getName() + " is analyzing the parking meter for the " + pCar3.getMake() + " " + pCar3.getModel());
        if(pOff3.parkedIllegal()){
            System.out.println("The " + pCar3.getMake() + " " + pCar3.getModel() + " is parked Illegaly. Issuing parking ticket...");
            pOff3.issueTicket();
        }
        else{
            System.out.println("Car is parked legally.");
        }
    }
    
}
