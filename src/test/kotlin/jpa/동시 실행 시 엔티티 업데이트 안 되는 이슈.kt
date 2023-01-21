package jpa

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import javax.persistence.Entity
import javax.persistence.Id

@DataJpaTest
class `동시 실행 시 엔티티 업데이트 안 되는 이슈` @Autowired constructor(
  private val testEntityManager: TestEntityManager
) {

    @Test
    fun `엔티티 업데이트 불가 이슈 `(){

    }

    @Test
    fun `엔티티 업데이트 불가 이슈 해결 `(){

    }
}


@Entity
class WrongWallet(
    @Id private val userId: Long,
    private val money: Long
)

@Entity
class CorrectWallet(
    @Id private val userId: Long,
    private val money: Long
)
