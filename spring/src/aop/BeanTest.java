package aop;

public class BeanTest {
    public static void main(String[] args) {
        Chinese p = new Chinese();
        StoneAxe axe = new StoneAxe();
        p.setAxe(axe);
        p.useAxe();
    }
}