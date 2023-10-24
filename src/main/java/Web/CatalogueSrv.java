package Web;

import java.io.IOException;  

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.gestCatalogue;
import Dao.iGestCatalogue;
import entite.produit;

/**
 * Servlet implementation class CatalogueSrv
 */
@WebServlet("/catalogue")
public class CatalogueSrv extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private iGestCatalogue gestCatalogue;

    public CatalogueSrv() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
        super.init();

        // Initialize the gestionCategorie object here
        gestCatalogue = new gestCatalogue(); // Replace with your actual implementation
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String action = request.getParameter("action");
    	if (action != null) { 
    		
            switch (action) {
            
            	case "edit":
                    int eid = Integer.parseInt(request.getParameter("id"));
                    String ename = request.getParameter("name");
                    String eref = request.getParameter("ref");
                    int equantity = Integer.parseInt(request.getParameter("qte"));
                    produit eproduct = new produit(eid, ename, eref, equantity);
                    System.out.print(eproduct);	
            		gestCatalogue.updateProduct(eproduct);
                    System.out.print(eproduct);	
            		showProducts(request, response);
            	break;
                	
            	case "add":
            		request.getRequestDispatcher("addProduct.jsp").forward(request, response);
            		break;
            		
            	case "newProduct":
          
                    int id = Integer.parseInt(request.getParameter("id"));
                    String name = request.getParameter("name");
                    String ref = request.getParameter("ref");
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    produit product = new produit(id, name, ref, quantity);
                    gestCatalogue.addProduct(product);
                    showProducts(request, response);
            		break;
                
            	case "delete":
            		// Handle delete action
            		int productid = Integer.parseInt(request.getParameter("id"));
            		// Perform the delete action
            		gestCatalogue.deleteProduct(productid);
            		
            		showProducts(request, response);
            		break;
            		
            	case "search":
            		// Handle delete action
            		
            		String arg = request.getParameter("arg");
            		// Get the list of products from the DAO
            		List<produit> produits = gestCatalogue.getproduitsBYMC(arg);

            		// Set the list of products as an attribute in the request
            		request.setAttribute("produits", produits);

            		// Forward the request to a JSP page for rendering
            		request.getRequestDispatcher("product.jsp").forward(request, response);
            		
            		break;
            		
            	default:
            		// Handle other actions or provide an error response
            		break;
            }	
    	}
    	else {
    		showProducts(request, response);
    	}
    }
    
    private void showProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// Get the list of products from the DAO
		List<produit> produits = gestCatalogue.getAllProducts();

		// Set the list of products as an attribute in the request
		request.setAttribute("produits", produits);

		// Forward the request to a JSP page for rendering
		request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
