package foo.bar

class PersonID {
    String name, surname
    int age
    PersonID(String name, String surname, int age) {
        this.name = name
        this.surname = surname
        this.age = age
    }
}

def getPerson(PersonID person) {
    return person.getName()
}
