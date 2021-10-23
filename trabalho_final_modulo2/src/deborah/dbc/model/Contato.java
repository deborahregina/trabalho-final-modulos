package deborah.dbc.model;

    public class Contato {
        private Cliente pessoa;
        private Integer idContato;
        private String descricao;
        private String telefone;
        private TipoContato tipo;

        public Contato(String descricao, String telefone, TipoContato tipo) {
            this.descricao = descricao;
            this.telefone = telefone;
            this.tipo = tipo;
        }

        public Contato() {
        }

        public Cliente getCliente() {
            return pessoa;
        }

        public void setCliente(Cliente pessoa) {
            this.pessoa = pessoa;
        }

        public Contato(Integer idContato, String descricao, String telefone, TipoContato tipo) {
            this.idContato = idContato;
            this.descricao = descricao;
            this.telefone = telefone;
            this.tipo = tipo;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public TipoContato getTipo() {
            return tipo;
        }

        public void setTipo(TipoContato tipo) {
            this.tipo = tipo;
        }

        public Integer getIdContato() {
            return idContato;
        }

        public void setIdContato(Integer idContato) {
            this.idContato = idContato;
        }

        @Override
        public String toString () {
            String tipoContato = "";
            if (tipo.getTipo() == 1) {
                tipoContato = "Residencial";
            }
            if (tipo.getTipo() == 2) {
                tipoContato = "Comercial";
            }
            return "ID DO CONTATO: "+getIdContato()+"\nID do cliente: "+ getCliente().getIdCliente()+"\nNome do cliente: "+getCliente().getNome()+"\nDescrição do contato: " + descricao + "\nTelefone: " +  telefone + "\nTipo: " + tipoContato + "\n";
        }
    }


