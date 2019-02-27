package app.dao.jdbc;

import app.dao.ProductDao;
import app.dao.jdbc.mapper.ProductMapper;
import app.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcProductDao implements ProductDao {
    private static final String SQL_SELECT_ALL = "select id, name, description, price from product order by id";
    private static final String SQL_SELECT_BY_ID = "select id, name, description, price from product where id = ?";
    private static final String SQL_DELETE_BY_ID = "delete from product where id = ?";
    private static final String SQL_INSERT = "insert into product(id, name, description, price) values (nextval('product_seq'),?, ?, ?)";
    private static final String SQL_UPDATE_BY_ID = "update product set name = :name, description = :description, " +
            "price = :price where id = :id";

    private static final ProductMapper PRODUCT_MAPPER = new ProductMapper();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, PRODUCT_MAPPER);
    }

    @Override
    public Product findById(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, PRODUCT_MAPPER, id);
    }

    @Override
    public void insert(Product product) {
        jdbcTemplate.update(SQL_INSERT, product.getName(), product.getDescription(), product.getPrice());
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, id);
    }

    @Override
    public void update(Product product) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", product.getId());
        parameterSource.addValue("name", product.getName());
        parameterSource.addValue("description", product.getDescription());
        parameterSource.addValue("price", product.getPrice());

        namedParameterJdbcTemplate.update(SQL_UPDATE_BY_ID, parameterSource);
    }

}
