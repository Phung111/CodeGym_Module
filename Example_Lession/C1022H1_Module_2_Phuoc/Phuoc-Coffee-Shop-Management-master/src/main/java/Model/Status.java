package Model;

public enum Status {
    Processing(2),Pending(1),Paid(3),NotPaid(4),Canceled(5);
    private int id;

    Status(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static Status findStatusByName (String name){
        for (Status i : values()){
            String temp = String.valueOf(i);
            if (temp.equals(name)){
                return i;
            }
        }
        return null;
    }

}
