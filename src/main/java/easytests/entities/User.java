package easytests.entities;

import easytests.entities.user.CommonFieldsInterface;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="users")
public class User implements CommonFieldsInterface {

    @Id
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="firstname", nullable = false)
    private String firstName;

    @Column(name="lastname", nullable = false)
    private String lastName;

    @Column(name="surname", nullable = false)
    private String surname;

    public User(String firstName, String lastName, String surname) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
    }

    protected User(){}

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

}