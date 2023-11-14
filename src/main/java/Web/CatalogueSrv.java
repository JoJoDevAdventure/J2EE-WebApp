package Web;

import java.io.IOException;    

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.GestionCatalogueImpl;
import Dao.GestionCategorieImpl;
import Dao.iGestCatalogue;
import entite.Produit;
import entite.Categorie;

/**
 * Servlet implementation class CatalogueSrv
 */
@WebServlet("/catalogue")
public class CatalogueSrv extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private GestionCatalogueImpl gestCatalogue;
    private GestionCategorieImpl gestCategorie;
    

    public CatalogueSrv() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
        super.init();

        // Initialize the gestionCategorie object here
        gestCatalogue = new GestionCatalogueImpl(); // Replace with your actual implementation
        gestCategorie = new GestionCategorieImpl();
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
                    int ecategorieId = Integer.parseInt(request.getParameter("ctg"));
                    Categorie ecategorie = gestCategorie.getGategorie(ecategorieId);
                    
                    Produit eproduct = new Produit(eid, ename, eref, equantity, ecategorie);
                    System.out.print(eproduct);	
            		gestCatalogue.updateProduct(eproduct);
                    System.out.print(eproduct);	
            		showProducts(request, response);
            	break;
                	
            	case "add":
            		List<Categorie> categories = gestCategorie.getAllCategories();
            		request.setAttribute("categories", categories);
            		request.getRequestDispatcher("addProduct.jsp").forward(request, response);
            		break;
            		
            	case "newProduct":
                    String name = request.getParameter("name");
                    String ref = request.getParameter("ref");
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    int categorieId = Integer.parseInt(request.getParameter("ctg"));
                    
                    Categorie categorie = gestCategorie.getGategorie(categorieId);
                    
                    Produit product = new Produit(name, ref, quantity, categorie);
                    
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
            		List<Produit> produits = gestCatalogue.getproduitsBYMC(arg);

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
		List<Produit> produits = gestCatalogue.getAllProducts();

		// Set the list of products as an attribute in the request
		request.setAttribute("produits", produits);
		
		List<Categorie> categories = gestCategorie.getAllCategories();
		request.setAttribute("categories", categories);

		// Forward the request to a JSP page for rendering
		request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
