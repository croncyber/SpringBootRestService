//package com.croncyber.api.repository;
//
//import com.croncyber.api.model.User;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//
//import java.util.List;
//
////public interface UserRepository {
////    Collection<User> getAll();
////
////    void save(User user);
////
////    Optional<User> getById(Integer id);
////}
//
//
//@RepositoryRestResource(collectionResourceRel = "user", path = "user")
//public interface UserRepository extends PagingAndSortingRepository<User, Long> {
//      //  Collection<User> getAll();
//
//
//  //  void save(User user);
//
//   // Optional<User> getById(Integer id);
//    List<User> findByLastName(@Param("name") String name);
//
//   // Collection<User> getAll();
//}
