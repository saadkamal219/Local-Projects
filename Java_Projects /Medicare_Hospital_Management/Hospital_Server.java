public class Hospital_Server {
    
    private String docName;
    private String docDesignation;
    private String doccontactNumber;

    private String patientName;
    // private String patientAddress;
    private String patientContactNumber;
    private int appointmentid;
    private String docInitial;

    private String userObjection;

    public Hospital_Server (String docName, String docDesignation, String doccontactNumber) {

        this.docName = docName;
        this.docDesignation = docDesignation;
        this.doccontactNumber = doccontactNumber;

    }

    public Hospital_Server (String patientName, String patientContactNumber, int appointment, String docInitial) {

        this.patientName = patientName;
        this.patientContactNumber = patientContactNumber;
        this.appointmentid = appointment;
        this.docInitial = docInitial;

    }

    public Hospital_Server (String userObjection) {

        this.userObjection = userObjection;

    }

    public void setdocName (String docName) {
        this.docName =  docName;
    }

    public void setdocDesignation (String docDesignation) {
        this.docDesignation = docDesignation;
    }

    public void setdoccontactNumber (String doccontactNumber) {
        this.doccontactNumber = doccontactNumber;
    }

    public void setpatientName (String patientName) {
        this.patientName = patientName;
    }

    public void setpatientContactNumber (String patientContactNumber) {
        this.patientContactNumber = patientContactNumber;
    }

    public void setappointment (int appointment) {
        this.appointmentid = appointment;
    }

    public void setdocInitial (String docInitial) {
        this.docInitial = docInitial;
    }

    public String getdocName () {
        return docName;
    }

    public String getdocDesignation () {
        return docDesignation;
    }

    public String getdoccontactNumber () {
        return doccontactNumber;
    }

    public String getpatientName () {
        return patientName;
    }

    public String getpatientContactNumber () {
        return patientContactNumber;
    }

    public String getUserObjection () {
        return userObjection;
    }

    public int getappointment () {
        return appointmentid;
    }

    public String getdocInitial () {
        return docInitial;
    }

}
