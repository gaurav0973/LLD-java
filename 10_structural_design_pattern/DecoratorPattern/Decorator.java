public class Decorator {
    public static void main(String[] args) {
        Chai chai = new GingerChai(new AdarakChai(new PlainChai()));
        System.out.println(chai.getDescription());
    }
}


interface Chai {
    String getDescription();
}


class PlainChai implements Chai {
    @Override
    public String getDescription() {
        return "Plain Chai";
    }
}


class GingerChai implements Chai {

    private Chai chai;

    public GingerChai(Chai chai) {
        this.chai = chai;
    }

    @Override
    public String getDescription() {
        return chai.getDescription() + " + Ginger";
    }
}



class AdarakChai implements Chai {

    private Chai chai;

    public AdarakChai(Chai chai) {
        this.chai = chai;
    }

    @Override
    public String getDescription() {
        return chai.getDescription() + " + Adarak";
    }
}


