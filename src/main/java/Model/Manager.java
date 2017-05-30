package Model;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Klasa dyrektora dziedzicząca po abstrakcyjnej klasie pracownika
 * @author Jaromir
 */

@Entity(noClassnameStored = true)
public class Manager extends Employee {

    //region Constructors

    public Manager(){}
    public Manager(String name, String surname){
        super(name, surname);
    }
    public Manager(String name, String surname, String jobPosition){
        super(name, surname, jobPosition);
    }
    //endregion

    //region Methods

    @Override
    public String toString() {
        return super.toString() + this.jobPosition + " ["+ this.getName()+" "+this.getSurname() +"]";
    }

    //endregion

}
