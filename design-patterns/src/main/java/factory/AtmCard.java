package factory;

public class AtmCard implements CardProvider{
    @Override
    public void swipe(float amt) {

    }

    @Override
    public String getBank() {
        return "abc";
    }
}
