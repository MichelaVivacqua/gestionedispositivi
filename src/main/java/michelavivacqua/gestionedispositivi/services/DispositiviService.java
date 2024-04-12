package michelavivacqua.gestionedispositivi.services;

import michelavivacqua.gestionedispositivi.entities.Dipendente;
import michelavivacqua.gestionedispositivi.entities.Dispositivo;
import michelavivacqua.gestionedispositivi.exceptions.BadRequestException;
import michelavivacqua.gestionedispositivi.exceptions.NotFoundException;
import michelavivacqua.gestionedispositivi.payloads.NewDipendenteDTO;
import michelavivacqua.gestionedispositivi.payloads.NewDispositivoDTO;
import michelavivacqua.gestionedispositivi.repositories.DipendentiDAO;
import michelavivacqua.gestionedispositivi.repositories.DispositiviDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositiviService {
    @Autowired
    private DispositiviDAO dispositiviDAO;

    public DispositiviService(DispositiviDAO dispositiviDAO) {
        this.dispositiviDAO = dispositiviDAO;
    }

    public List<Dispositivo> getDispositiviList() {
        return dispositiviDAO.findAll();
    }



    public Dispositivo saveDispositivo(NewDispositivoDTO newDispositivoDTO) {

        Dispositivo dispositivo = new Dispositivo(newDispositivoDTO.tipologia(),newDispositivoDTO.stato());
        System.out.println(dispositivo);
        return dispositiviDAO.save(dispositivo);
    }


    public Dispositivo findById(int id) {
        return dispositiviDAO.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public Dispositivo findByIdAndUpdate(int id, Dispositivo updatedDispositivo) {
        Dispositivo found = findById(id);
        found.setTipologia(updatedDispositivo.getTipologia());
        found.setStato(updatedDispositivo.getStato());
        return dispositiviDAO.save(found);
    }

    public void findByIdAndDelete(int dispositivoId) {
        dispositiviDAO.deleteById(dispositivoId);
    }
}