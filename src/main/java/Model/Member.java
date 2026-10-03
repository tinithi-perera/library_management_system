package Model;

public class Member {

        private String memberId;
        private String fullName;
        private String email;
        private String phone;
        private String address;

        public Member(String memberId, String fullName, String email, String phone, String address) {
            this.memberId = memberId;
            this.fullName = fullName;
            this.email = email;
            this.phone = phone;
            this.address = address;
        }

        public String getMemberId() {
            return memberId;
        }

        public String getFullName() {
            return fullName;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getAddress() {
            return address;
        }
    }

