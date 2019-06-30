import java.io.Serializable;

class Message implements Serializable {
    String operation;
    String fields;
    String text;
    Message()
    {
        this.operation = "";
        this.fields = "";
        this.text = "";
    }

    void setOperation(String operation)
    {
        this.operation = operation;
    }
    void setFields(String s)
    {
        this.fields = s;
    }
    void setText(String text)
    {
        this.text = text;
    }

    String getOperation(){
        return this.operation;
    }
    String getFields(){
        return  this.fields;
    }
    String getMessage(){
        return this.text;
    }
}
