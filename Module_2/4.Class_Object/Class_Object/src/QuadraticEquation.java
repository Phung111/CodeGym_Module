public class QuadraticEquation {
    int a, b, c, delta,r1,r2;

    public QuadraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA(){
        return this.a;
    }
    public int getB(){
        return this.b;
    }
    public int getC(){
        return this.c;
    }
    public int getDiscriminant(){
        return delta = (int) (Math.pow(this.b, 2) - 4*this.a*this.c);
    }
    public int getRoot1(){
        return r1 = (int) ((-this.b)+Math.pow(delta, 0.5)/(2*this.a));
    }

    public int getRoot2(){
        return r2 = (int) ((-this.b)-Math.pow(delta, 0.5)/(2*this.a));
    }

}


