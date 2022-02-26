package com.thymspringricard.firstthymericardo.controller;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import com.thymspringricard.firstthymericardo.model.Login;
import com.thymspringricard.firstthymericardo.model.Produto;
import com.thymspringricard.firstthymericardo.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CriptoController{

    @Autowired
    private LoginController loginC;
	@Autowired
	private ProdutoController prodC;

    private String senhaMsg = "";

    // private Criptografia criptografia;
    // String msgn = criptografia.Encriptar("shuash");
    String msgn = "teste depois class criptografia";

    @GetMapping("/crip")
    public String getUsuario(Model model)
    {
        String name = "ooooouuuWorld";
		model.addAttribute("sigilo", name);
		return "cripto";
    }

    @GetMapping
    public String getMenu(Model model)
    {
		return "menu";
    }

    @GetMapping("/login")
    public String getLogin(Model model)
    {
		return "login";
    }

    @GetMapping("/criptar")
	public String getCriptar(Model model){ 
        msgn = Encriptar("ricardo");       
		model.addAttribute("scret", msgn);
        return "cript_result";
	}

    @GetMapping("/listlogins")
	public String getListaLogin(Model model){
        List<Usuario> listaLog = loginC.listagenLog();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
		Calendar cal = Calendar.getInstance();
		String sDataAux;
		
		dateFormat.applyPattern("dd 'de' MMMM 'de' yyyy");
		sDataAux = dateFormat.format(cal.getTime());
	
		model.addAttribute("data", LocalDateTime.now());
		model.addAttribute("dataExtenso", "<b>" + sDataAux + "</b>");
		model.addAttribute("nome", "Ricardo");
		model.addAttribute("sobrenome", "Bavaresco");
		model.addAttribute("titulo", "Lista de Produtos");

		model.addAttribute("logins",listaLog);
        return "lista_logins";
	}

    @GetMapping("/tstAdd")
	public String tstAdd(Model model){
        return "adicionarLogin";
	}


    public String Encriptar(String msg) {
    String msgCript = "asnaeb";
        for (int n = 0; n <msg.length(); n++) {
            msgCript += ((msg.charAt(n) ^ senhaMsg.charAt(n)));                
        }
        return msgCript;
    }

	@GetMapping("/listaprodutos")
	public ResponseEntity<List<Produto>> listarProdutos() {
		List<Produto> listprod = prodC.listagenProd();

        if (listprod.size() > 0 ) {
            return ResponseEntity.ok(listprod);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
// //	@GetMapping("/produto/{id}")
// //	public Optional<Produto> buscarProduto(@PathVariable(value="id") long id) {
// //		return produtoRepository.findById(id);
// //	}
	
// 	@RequestMapping(value="/produto/{id}", method=RequestMethod.GET, produces="application/json")
// 	public ResponseEntity<Produto> buscarProduto(@PathVariable(value="id") long id) {
// 		Optional<Produto> produto = produtoRepository.findById(id);
		
// 		if(produto.isPresent()) {
// 			return new ResponseEntity<Produto>(produto.get(), HttpStatus.OK);
// 		} else {
// 			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// 		}
// 	}

// 	// Incluir produto
	// @PostMapping("/produto")
	// public void salvarProduto(@ModelAttribute Produto produto) {
	// 	prodC.salvarLogin(produto);
	// }
	
 	// Salvar produto
	@PostMapping("/produto")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return prodC.salvarLogin(produto);
	}
	
// 	@DeleteMapping("/produto")
// 	public void deletarProduto(@RequestBody Produto produto) {
// 		produtoRepository.delete(produto);
// 	}
	
// 	@RequestMapping(value={"/exibirprodutoxml", "/exibirprodutoxml/{id}"}, produces = {"text/xml"})
// 	public ResponseEntity<?> exibirProdutoXML(@PathVariable Optional<Long> id, HttpSession session) {
// 		if (id.isPresent()) {
// 			Optional<Produto> produto = Optional.ofNullable(produtoRepository.findById(id.get())).orElse(null);
			
// 		    if (produto.isPresent()) {
// 		      return new ResponseEntity<>(produto.get(), HttpStatus.OK);
// 		    } else {
// 		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
// 		    }
// 		} else {
// 			return ResponseEntity.badRequest().body("Parâmetro não informado");
// 		}
// 	}

}



