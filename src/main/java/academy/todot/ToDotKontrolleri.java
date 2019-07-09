package academy.todot;

import academy.todot.dao.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@RequestMapping("/api/todo")
@RestController
public class ToDotKontrolleri {
    private TodoDao dao;

    @Autowired
    public ToDotKontrolleri (TodoDao dao){
        this.dao=dao;
    }
    @GetMapping("")
    public List<ToDo> listaaTehtavat() {
        List<ToDo> kaikki = dao.naytaKaikki();
        System.out.printf("Haetaan listaa, alkioita: %d kpl\n", kaikki.size());
        return kaikki;
    }
    @PostMapping("")
    public ResponseEntity<?> luoUuusi(@RequestBody ToDo uusi) throws SQLException {
        System.out.println("****** Luodaan uutta todo:ta: " + uusi);
        int id = dao.lisaa(uusi);
        System.out.println("****** Luotu uusi todo: " + uusi);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).body(uusi);
    }
    @DeleteMapping("/{id}")
    public void poista(@PathVariable int id)throws SQLException {
        dao.poista(id);


     /*   return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new Virheviestit(String.format("Id %d ei ole olemassa: ei poistettu", id)));  */
    }
 //   @RequestMapping("api/todo") // url tälle metodille: http://localhost:8080/todo
 //   public String loginMessage(){
 //       return "ToDo";
 //   }
}
