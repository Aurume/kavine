package kaviney;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

//import kaviney.Produktai;

public class ProduktasMapper implements RowMapper<Produktas>  {
	
   public Produktas mapRow(ResultSet rs, int rowNum) throws SQLException {
	   
      Produktas produktas = new Produktas();
      produktas.setId(rs.getInt("id"));
      produktas.setPav(rs.getString("pav"));
      produktas.setMat_vnt(rs.getString("mat_vnt"));
      produktas.setMat_kiek(rs.getInt("mat_kiek"));
      //uzsakymas.setBusena( rs.getString("busena") );
      produktas.setKaina(rs.getDouble("kaina"));
      produktas.setKiekis_sand(rs.getDouble("kiekis_sand"));
      
	return produktas;
   }
}	
	
