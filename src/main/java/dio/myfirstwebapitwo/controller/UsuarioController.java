package dio.myfirstwebapitwo.controller;



import dio.myfirstwebapitwo.model.Usuario;
import dio.myfirstwebapitwo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    private UserRepository repository;

    private UsuarioController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping()
    public List<Usuario> getUsers(){
        return  repository.findAll();

    }
    @GetMapping("/{username}")
    public  Usuario getOne(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }
    @PostMapping()
    public void postUser(@RequestBody Usuario usuario){
        repository.save(usuario);

    }
    @PutMapping()
    public void putUser(@RequestBody Usuario usuario){
        repository.save(usuario);

    }

}