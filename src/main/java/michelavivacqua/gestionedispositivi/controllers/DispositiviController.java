package michelavivacqua.gestionedispositivi.controllers;


import michelavivacqua.gestionedispositivi.entities.Dispositivo;
import michelavivacqua.gestionedispositivi.exceptions.BadRequestException;
import michelavivacqua.gestionedispositivi.payloads.NewDispositivoDTO;
import michelavivacqua.gestionedispositivi.payloads.NewDispositivoRespDTO;
import michelavivacqua.gestionedispositivi.services.DispositiviService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivi")
public class DispositiviController {
    @Autowired
    private DispositiviService dispositiviService;

    //    1. POST http://localhost:3001/dispositivi (+ body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewDispositivoRespDTO saveDispositivo(@RequestBody @Validated NewDispositivoDTO body, BindingResult validation){

        if(validation.hasErrors()) {
            System.out.println(validation.getAllErrors());
            throw new BadRequestException(validation.getAllErrors());
        }
        System.out.println(body);
        return new NewDispositivoRespDTO(this.dispositiviService.saveDispositivo(body).getId());}



    // 2. GET http://localhost:3001/dispositivi/{{dispositivoId}}
    @GetMapping("/{dispositivoId}")
    private Dispositivo findDispositivoById(@PathVariable int dispositivoId){
        return this.dispositiviService.findById(dispositivoId);
    }

    //    3. GET http://localhost:3001/dispositivi
    @GetMapping
    private List<Dispositivo> getAllDispositivo(){
        return this.dispositiviService.getDispositiviList();
    }


    // 4. PUT http://localhost:3001/dispositivi/{{dispositivoId}} (+ body)
    @PutMapping("/{dispositivoId}")
    private Dispositivo findByIdAndUpdate(@PathVariable int dispositivoId, @RequestBody Dispositivo body){
        return this.dispositiviService.findByIdAndUpdate(dispositivoId, body);
    }



    // 5. DELETE http://localhost:3001/dispositivi/{dispositivoId}
    @DeleteMapping("/{dispositivoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDispositivoById(@PathVariable int dispositivoId) {
        this.dispositiviService.findByIdAndDelete(dispositivoId);
    }
}
