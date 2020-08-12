package models.response;

public class ResponseNewPatientData {

        private String doctor_id;

        private String createdAt;

        private Prescription[] prescription;

        private String patient_id;

        private String __v;

        private String weight;

        private String _id;

        private String height;

        private String updatedAt;

        public String getDoctor_id() {
            return doctor_id;
        }

        public void setDoctor_id(String doctor_id) {
            this.doctor_id = doctor_id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Prescription[] getPrescription() {
            return prescription;
        }

        public void setPrescription(Prescription[] prescription) {
            this.prescription = prescription;
        }

        public String getPatient_id() {
            return patient_id;
        }

        public void setPatient_id(String patient_id) {
            this.patient_id = patient_id;
        }

        public String get__v() {
            return __v;
        }

        public void set__v(String __v) {
            this.__v = __v;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        @Override
        public String toString() {
            return "ClassPojo [doctor_id = " + doctor_id + ", createdAt = " + createdAt + ", prescription = " + prescription + ", patient_id = " + patient_id + ", __v = " + __v + ", weight = " + weight + ", _id = " + _id + ", height = " + height + ", updatedAt = " + updatedAt + "]";
        }
    }

