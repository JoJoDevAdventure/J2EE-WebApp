package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entite.produit;

public class GestionCatalogue implements IGestionCatalogue{
	Connection cnx=SingletonConnection.getInstance();
	
	@Override
	public void addProduct(produit p) {
		// TODO Auto-generated method stub
		
		try {
			
			PreparedStatement ps = cnx.prepareStatement("insert into produit(id, nom, prenom, qte) values(?, ?, ?, ?)");
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getPren());
			ps.setInt(4, p.getQte());
			ps.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block,
			e1.printStackTrace();
		}
		
	}

	@Override
	public List<produit> getAllProducts() {
		// TODO Auto-generated method stub
		List<produit>liste=new ArrayList<>();
		try {
			PreparedStatement ps=cnx.prepareStatement("select * from produit");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				liste.add(new produit(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getInt(4)));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			return liste;
	
	

		
	}

	@Override
	public void deleteProduct(int id) {
		try {
			PreparedStatement ps=cnx.prepareStatement("delete from produit where id=?");
			  ps.setInt(1, id);
			     
			     ps.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateProduct(produit p) {
		try {
			PreparedStatement ps=cnx.prepareStatement("update produit set nom=?, prenom=?, qte=? where id=?");
			  ps.setString(1, p.getNom());
			     ps.setString(2, p.getPren());
			     ps.setInt(3, p.getQte());
			     ps.setInt(4, p.getId());
			     ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public produit getProduct(int id) {
		produit p = null;
		try {
			PreparedStatement ps=cnx.prepareStatement("Select * from produit where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			
			p.setNom(rs.getString(2));
			p.setPren(rs.getString(3));
			p.setQte(rs.getInt(4));
			p.setId(rs.getInt(1));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<produit> getproduitsBYMC(String mc) {
		List<produit>liste=new ArrayList<>();
		try {
			PreparedStatement ps=cnx.prepareStatement("select * from produit where nom like ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				liste.add(new produit(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getInt(4)));
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

}
