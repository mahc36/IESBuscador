package dao.program.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.program.IProgramDao;
import dto.IesDTO;
import dto.ProgramDTO;
import dto.ProgramsFilterDTO;
import util.PersistUtil;

public class ProgramDao implements IProgramDao {
	
	private void setInfoProgram(ResultSet result, ProgramsFilterDTO programsFilterDTO) throws Exception {
		programsFilterDTO.setProgramName(result.getString("pro_name"));
		programsFilterDTO.setAcademicLevel(result.getString("pro_academic_level"));
		programsFilterDTO.setModality(result.getString("pro_modality"));
		programsFilterDTO.setCredit(result.getInt("pro_credits"));
		programsFilterDTO.setCreditCost(result.getInt("pro_credit_cost"));
		programsFilterDTO.setKnowledgeArea(result.getString("pro_knowledge_area"));
		programsFilterDTO.setCampusName(result.getString("cam_name"));
		programsFilterDTO.setCampusCity(result.getString("cam_city"));
		programsFilterDTO.setCampusLocation(result.getString("cam_location"));
		programsFilterDTO.setIesName(result.getString("ies_name"));
		programsFilterDTO.setIesEscudo(result.getString("ies_escudo"));
		programsFilterDTO.setIesCaracter(result.getString("ies_caracter"));
		programsFilterDTO.setIesAccreditation(result.getBoolean("ies_accreditation"));
	}
	
	@Override
	public List<ProgramsFilterDTO> filter(Connection con) throws Exception {
		PreparedStatement instruction = null;
		ResultSet result = null;
		String query;
		ProgramsFilterDTO programsFilterDTO;
		List<ProgramsFilterDTO> programsList = new ArrayList<>();
		try {
			query = ProgramSql.FILTER;
			System.out.println(query);
			instruction = con.prepareStatement(query);
			result = instruction.executeQuery();
			while (result.next()) {
				programsFilterDTO = new ProgramsFilterDTO();
				setInfoProgram(result, programsFilterDTO);
				programsList.add(programsFilterDTO);
			}
			for (ProgramsFilterDTO programsFilterDTO2 : programsList) {
				System.out.println(programsFilterDTO2.getIesName());
			}
		} catch (SQLException sql) {
			System.out.println(sql.toString());
			con.rollback();
			throw new Exception(sql.toString());
		} finally {
			PersistUtil.closeResources(instruction);
		}
		return programsList;
	}

}