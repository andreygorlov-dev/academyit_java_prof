package lesson1.templater;

public class School extends Education{
    @Override
    public void income() {
        System.out.println("Без экз");
    }

    @Override
    public void learn() {
        System.out.println("Уроки и ДЗ");
    }

    @Override
    public void getDocument() {
        System.out.println("Аттестат");
    }
}
