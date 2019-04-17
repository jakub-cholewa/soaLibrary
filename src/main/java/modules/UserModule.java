package modules;

import repositories.ReaderRepository;
import model.Reader;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "userModule",eager = true)
@ApplicationScoped
public class UserModule {
    private Reader readerEntity = new Reader();

    private List<SelectItem> readers;

    @PostConstruct
    public void init() {
        readers = new ArrayList<>();
        for(Reader reader: ReaderRepository.readAllReaders()){
            readers.add(new SelectItem(reader.getReaderId(), reader.getName()));
        }
    }

    public String saveReader(){
        ReaderRepository.addReader(readerEntity);
        return "index";
    }

    public Reader getReaderEntity() {
        return readerEntity;
    }

    public void setReaderEntity(Reader readerEntity) {
        this.readerEntity = readerEntity;
    }

    public List<SelectItem> getReaders() {
        return readers;
    }
}
