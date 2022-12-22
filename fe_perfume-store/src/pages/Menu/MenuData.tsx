import {PerfumePrice} from "../../types/types";

export const perfumer: Array<{ name: string }> = [
    {"name": "Burberry"},
    {"name": "Bvlgari"},
    {"name": "Calvin Klein"},
    {"name": "Carolina Herrera"},
    {"name": "Chanel"},
    {"name": "Creed"},
    {"name": "Dior"},
    {"name": "Dolce&Gabbana"},
    {"name": "Giorgio Armani"},
    {"name": "Gucci"},
    {"name": "Hermes"},
    {"name": "Hugo Boss"},
    {"name": "Jean Paul Gaultier"},
    {"name": "Lancome"},
    {"name": "Paco Rabanne"},
    {"name": "Prada"},
    {"name": "Tom Ford"},
    {"name": "Versace"},
];

export const gender: Array<{ name: string }> = [
    {"name": "Nam"},
    {"name": "Nữ"},
];

export const price: Array<PerfumePrice> = [
    {"id": 1, "name": "Tất cả", "array": []},
    {"id": 2, "name": "100000 - 300000 đ", "array": [100000, 300000]},
    {"id": 3, "name": "300000 - 500000 đ", "array": [300000, 500000]},
    {"id": 4, "name": "500000 - 1000000 đ", "array": [500000, 1000000]},
    {"id": 5, "name": "1000000 - 1500000+ đ", "array": [1000000, 5000000]}
];
