package modules;

import repositories.AuthorRepository;
import model.Author;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "authorModule",eager = true)
@ApplicationScoped
public class AuthorModule {
    private Author authorEntity = new Author();
    private List<Author> authors;

    public String saveAuthor(){
        AuthorRepository.addAuthor(authorEntity);
        return "index?faces-reditect=true";
    }

    public Author getAuthorEntity() {
        return authorEntity;
    }

    public void setAuthorEntity(Author authorEntity) {
        this.authorEntity = authorEntity;
    }

}
