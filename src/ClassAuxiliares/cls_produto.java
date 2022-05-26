package ClassAuxiliares;
public class cls_produto {
    private String _codigo;
    private String _nome;
    private double _valor;
    private int _qtde;

    
    public cls_produto(String _codigo, String _nome, double _valor, int _qtde) throws  Exception {
        this._codigo = _codigo;
        this._nome = _nome;
        this._valor = _valor;
        this._qtde = _qtde;
    }
    //recuperando valores
    public String get_codigo() {
        return _codigo;
    }
    public int get_qtde() {
        return _qtde;
    }
    public void set_qtde(int _qtde) {
        this._qtde = _qtde;
    }
    public double get_valor() {
        return _valor;
    }

    //definindo valores
    public void set_valor(double _valor) {
        this._valor = _valor;
    }
    public String get_nome() {
        return _nome;
    }
    public void set_nome(String _nome) {
        this._nome = _nome;
    }
    public void set_codigo(String _codigo) {
        this._codigo = _codigo;
    }
    
    @Override
    public String toString() {
        return "produto [_codigo=" + _codigo + ", _nome=" + _nome + ", _qtde=" + _qtde + ", _valor=" + _valor + "]";
    }

    
}
