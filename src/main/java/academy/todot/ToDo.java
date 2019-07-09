package academy.todot;

import org.springframework.stereotype.Component;

@Component
public class ToDo {

    String tehtava;
    int id;

    public ToDo(){
    }
    public ToDo (String tehtava){
        this.tehtava=tehtava;
    }

    public String getTehtava() {
        return tehtava;
    }

    public void setTehtava(String tehtava) {
        this.tehtava = tehtava;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
