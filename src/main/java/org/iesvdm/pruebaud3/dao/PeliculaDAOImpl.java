package org.iesvdm.pruebaud3.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.pruebaud3.modelo.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class PeliculaDAOImpl implements PeliculaDAO{

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Override
        public List<Pelicula> getAll() {

            List<Pelicula> listpeliculas = jdbcTemplate.query(
                    "SELECT * FROM pelicula",
                    (rs, rowNum) -> new Pelicula(rs.getInt("id_pelicula"),
                            rs.getString("titulo"),
                            rs.getString("descripcion"),
                            rs.getDate("fecha_lanzamiento"),
                            rs.getInt("id_idioma"),
                            rs.getInt("duracion_alquiler"),
                            rs.getDouble("rental_rate"),
                            rs.getInt("duracion"),
                            rs.getDouble("replacement_cost"),
                            rs.getDate("ultima_actualizacion"))
                    );

            log.info("Devueltos {} registros.", listpeliculas.size());

            return listpeliculas;

        }

    @Override
    public synchronized void create(Pelicula pelicula) {

        String sqlInsert =
                """
							INSERT INTO pelicula (titulo, descripcion, fecha_lanzamiento, idIdioma, duracionAlquiler, rentalRate, duracion, replacementCost, ultimaActualizacion) 
							VALUES  (  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?)
				""";

    }

    }
