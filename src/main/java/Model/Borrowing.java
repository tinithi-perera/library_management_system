package Model;

public class Borrowing {



        private String memberId;
        private String bookTitle;
        private String issueDate;
        private String dueDate;
        private String returnDate;
        private String status;


        public Borrowing(String memberId, String bookTitle,
                         String issueDate, String dueDate,
                         String returnDate, String status) {

            this.memberId = memberId;
            this.bookTitle = bookTitle;
            this.issueDate = issueDate;
            this.dueDate = dueDate;
            this.returnDate = returnDate;
            this.status = status;
        }


        public String getMemberId() {
            return memberId;
        }

        public String getBookTitle() {
            return bookTitle;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public String getDueDate() {
            return dueDate;
        }

        public String getReturnDate() {
            return returnDate;
        }

        public String getStatus() {
            return status;
        }
    }

