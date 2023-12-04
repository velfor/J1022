package by.itstep;

import java.io.Serializable;

public class HelloWorld implements Serializable {
    private String helloMessage;

    public HelloWorld(){
        helloMessage = "";
    }

    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HelloWorld)) return false;

        HelloWorld that = (HelloWorld) o;

        return getHelloMessage() != null ? getHelloMessage().equals(that.getHelloMessage()) : that.getHelloMessage() == null;
    }

}
