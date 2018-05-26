package classes;

import java.sql.SQLException;
import java.util.Collection;
import tables.Position;



public interface PositionDAO{
	public void addPosition(Position Position) throws SQLException;
	public void updatePosition(Long Position_id, Position Position) throws SQLException;
	public Position getPositionById(Long Position_id) throws SQLException;
	public Collection<Position> getAllPositions() throws SQLException;
	public void deletePosition(Position Position) throws SQLException;
	public Collection<Position> getPositionByFeature(Position position) throws SQLException;
	
}
