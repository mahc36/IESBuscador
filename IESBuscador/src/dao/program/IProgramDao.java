package dao.program;

import java.sql.Connection;
import java.util.List;

import dto.ProgramsFilterDTO;

public interface IProgramDao {
	public List<ProgramsFilterDTO> filter(Connection con) throws Exception;
}