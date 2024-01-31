package org.iesvdm.pruebaud3.controlador;

import org.iesvdm.pruebaud3.modelo.Pelicula;
import org.iesvdm.pruebaud3.service.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
@Controller
public class PeliculaController {


    private PeliculaService peliculaService;

    //Se utiliza inyección automática por constructor del framework Spring.
    //Por tanto, se puede omitir la anotación Autowired
    //@Autowired
    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping("/peliculas")
    public String listar(Model model) {

        List<Pelicula> listaPelicula =  peliculaService.listAll();
        model.addAttribute("listapelicula", listaPelicula);

        return "peliculas";

    }
/*
    @GetMapping("/pelicula/{id}")
    public String detalle(Model model, @PathVariable Integer id ) {

        Pelicula pelicula = peliculaService.one(id);
        model.addAttribute("pelicula", pelicula);

        return "detalle-pelicula";

    }
*/

    @GetMapping("/pelicula/crear")
    public String crear(Model model) {

        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);

        return "crear-pelicula";

    }

    @PostMapping("/pelicula/crear")
    public RedirectView submitCrear(@ModelAttribute("pelicula") Pelicula pelicula) {

        peliculaService.newcliente(pelicula);

        return new RedirectView("/peliculas") ;

    }
/*

    @GetMapping("/peliculas/editar/{id}")
    public String editar(Model model, @PathVariable Integer id) {

        Pelicula pelicula = peliculaService.one(id);
        model.addAttribute("pelicula", pelicula);

        return "editar-pelicula";

    }


    @PostMapping("/peliculas/editar/{id}")
    public RedirectView submitEditar(@ModelAttribute("pelicula") Pelicula pelicula) {

        peliculaService.replaceCliente(pelicula);

        return new RedirectView("/peliculas");
    }

    @PostMapping("/peliculas/borrar/{id}")
    public RedirectView submitBorrar(@PathVariable Integer id) {

        peliculaService.deleteCliente(id);

        return new RedirectView("/peliculas");
    }*/

}
