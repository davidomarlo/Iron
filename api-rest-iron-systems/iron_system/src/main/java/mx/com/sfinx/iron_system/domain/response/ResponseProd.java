package mx.com.sfinx.iron_system.domain.response;

public class ResponseProd extends ResponseToken {

    private int    statusprods;
        private String messageprod;
        private String description;

    public int getStatusprods() {
        return statusprods;
    }
    public void setStatusprods(int statusprods) {
        this.statusprods = statusprods;
    }
        public String getMessageprod() {

            return messageprod;
        }

        public void setMessageprod(String messageprod) {
            this.messageprod = messageprod;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }



