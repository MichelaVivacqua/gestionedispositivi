package michelavivacqua.gestionedispositivi.services;

import michelavivacqua.gestionedispositivi.entities.Dipendente;
import michelavivacqua.gestionedispositivi.exceptions.BadRequestException;
import michelavivacqua.gestionedispositivi.exceptions.NotFoundException;
import michelavivacqua.gestionedispositivi.payloads.NewDipendenteDTO;
import michelavivacqua.gestionedispositivi.repositories.DipendentiDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendentiService {
    @Autowired
    private DipendentiDAO dipendentiDAO;

    public DipendentiService(DipendentiDAO dipendentiDAO) {
        this.dipendentiDAO = dipendentiDAO;
    }

    public List<Dipendente> getDipendentiList() {
        return dipendentiDAO.findAll();
    }



    public Dipendente saveDipendente(NewDipendenteDTO newDipendenteDTO) {

        if (dipendentiDAO.existsByEmail(newDipendenteDTO.email())) {
            throw new BadRequestException("L'email " + newDipendenteDTO.email() + " è già in uso, quindi il dipendente risulta già registrato!");
        }

        Dipendente dipendente = new Dipendente(newDipendenteDTO.username(),newDipendenteDTO.name(), newDipendenteDTO.surname(), newDipendenteDTO.email(), newDipendenteDTO.propic());
        System.out.println(dipendente);
        return dipendentiDAO.save(dipendente);
    }


    public Dipendente findById(int id) {
        return dipendentiDAO.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public Dipendente findByIdAndUpdate(int id, Dipendente updatedDipendente) {
        Dipendente found = findById(id);
        found.setName(updatedDipendente.getName());
        found.setSurname(updatedDipendente.getSurname());
        return dipendentiDAO.save(found);
    }

    public void findByIdAndDelete(int dipendenteId) {
        dipendentiDAO.deleteById(dipendenteId);
    }



}
