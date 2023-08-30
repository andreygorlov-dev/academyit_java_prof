package lesson1.templater;

public abstract class Education {
    
    public void study() {
        income();
        learn();
        passExams();
        getDocument();
    }
    public abstract void income();

    public abstract void learn();

    private void passExams() {
        System.out.println("Сдача экзамепнов");
    }

    public abstract void getDocument();
}
