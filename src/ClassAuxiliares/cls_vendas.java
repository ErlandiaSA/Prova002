package ClassAuxiliares;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class cls_vendas {
    private LocalDate _dataVenda;
    private String _prdVendido;
    private int _qdtProduto;
    
    
    public cls_vendas(LocalDate _dataVenda, String _prdVendido, int _qdtProduto) throws  Exception {
        this._dataVenda = _dataVenda;
        this._prdVendido = _prdVendido;
        this._qdtProduto = _qdtProduto;
    }
    public int get_qdtProduto() {
        return _qdtProduto;
    }
    public void set_qdtProduto(int _qdtProduto) {
        this._qdtProduto = _qdtProduto;
    }
    public LocalDate get_dataVenda() {
        return _dataVenda;
    }
    public String get_prdVendido() {
        return _prdVendido;
    }
    public void set_prdVendido(String _prdVendido) {
        this._prdVendido = _prdVendido;
    }
    public void set_dataVenda(LocalDate _dataVenda) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this._dataVenda = _dataVenda;
    }
    @Override
    public String toString() {
        return "vendas [_dataVenda=" + _dataVenda + ", _prdVendido=" + _prdVendido + "]";
    }
    
    
}
