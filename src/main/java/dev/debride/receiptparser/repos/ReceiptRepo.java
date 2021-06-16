package dev.debride.receiptparser.repos;

import dev.debride.receiptparser.models.Receipt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface ReceiptRepo extends CrudRepository<Receipt, Integer> {
}
