const router = express.Router();//separer les roles, ici il s'occupe du routage
const {getCars,getCar,postCar,deleteCar,patchCar} = require('../controllers');

router.get('/api/cars', getCars);
router.get('/api/cars/:id', getCar);
router.post('/api/cars', postCar);
router.delete('/api/cars/:id',deleteCar);
router.patch('/api/cars/:id', patchCar);

module.exports = router;